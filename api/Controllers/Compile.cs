using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System.Text.Json;
using System.Text;

namespace api.Controllers
{
    [Route("[controller]")]
    public class Compile : Controller
    {
        private readonly ILogger<Compile> _logger;
        private static string TablaErrores = "";

        public Compile(ILogger<Compile> logger)
        {
            _logger = logger;
        }

        public class CompileRequest
        {
            [Required]
            public required string code { get; set; }
        }

        // POST /compile
        
        [HttpPost]
        public IActionResult Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid request" });
            }

            var inputStream = new AntlrInputStream(request.code);
            var lexer = new LanguageLexer(inputStream);

            // Add custom error listener
            lexer.RemoveErrorListeners();
            lexer.AddErrorListener(new LexicalErrorListener());

            var tokens = new CommonTokenStream(lexer);
            var parser = new LanguageParser(tokens);

            parser.RemoveErrorListeners();
            parser.AddErrorListener(new SyntaxErrorListener());
            
            Error.TableError.Clear();
            try
            {
                var tree = parser.program();

                var visitor = new CompilerVisitor();
                visitor.Visit(tree);

                return Ok(new { result = visitor.output });

            }
            catch (ParseCanceledException ex)
            {
                TablaErrores = new Error().GenerateErrorTable();
                return BadRequest(new { error = ex.Message });
            }
            catch (SemanticError ex)
            {
                TablaErrores = new Error().GenerateErrorTable();
                return BadRequest(new { error = ex.Message });
            }                                   
            catch (Exception ex)
            {
                TablaErrores = new Error().GenerateErrorTable();
                return BadRequest(new { error = ex.Message });
            }
    
        }
        

        [HttpPost("ReporteAST")]
        public async Task<IActionResult> DescargarReporteAST ([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid Request" });
            }

            string grammarPath = Path.Combine(Directory.GetCurrentDirectory(), "./grammars/Language.g4");
            var grammar ="";
            try
            {
                if (System.IO.File.Exists(grammarPath)){
                    grammar = await System.IO.File.ReadAllTextAsync(grammarPath);
                } else {
                    return BadRequest(new { error = "No se encontro el archivo de gramatica" });
                }
               
            }
            catch (System.Exception)
            {
                return BadRequest(new { error = "Error al leer el archivo de gramatica" });
            }
            
            var payload = new { 
                grammar,
                lexgrammar = "",
                input = request.code,
                start = "program" 
            };

            var JsonPayLoad = JsonSerializer.Serialize(payload);
            var context = new StringContent(JsonPayLoad, Encoding.UTF8, "application/json");
            using (var client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.PostAsync("http://lab.antlr.org/parse/", context);
                    response.EnsureSuccessStatusCode();

                    string result = await response.Content.ReadAsStringAsync();

                    using var doc = JsonDocument.Parse(result);
                    var root = doc.RootElement;

                    if (root.TryGetProperty("result", out JsonElement resultElement) && resultElement.TryGetProperty("svgtree", out JsonElement svgTreeElement))
                    {
                        string svgtree = svgTreeElement.GetString() ?? string.Empty;
                        return Content(svgtree, "image/svg+xml");
                    }
                    return BadRequest(new { error = "Error al obtener el reporte AST SVG" });
                }
                catch (System.Exception)
                {
                    return BadRequest(new { error = "Error al obtener el reporte AST" });
                }
            }
        }

        [HttpPost("GenerateSymbolTable")]
        public IActionResult GenerateSymbolTable([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid Request" });
            }

            var inputStream = new AntlrInputStream(request.code);
            var lexer = new LanguageLexer(inputStream);

            lexer.RemoveErrorListeners();
            lexer.AddErrorListener(new LexicalErrorListener());

            var tokens = new CommonTokenStream(lexer);
            var parser = new LanguageParser(tokens);

            parser.RemoveErrorListeners();
            parser.AddErrorListener(new SyntaxErrorListener());

            try
            {
                var tree = parser.program();
                var visitor = new CompilerVisitor();
                visitor.Visit(tree);

                string htmlTable = visitor.entornoActual.GenerateSymbolTableHtml();
                
                var bytes = Encoding.UTF8.GetBytes(htmlTable);

                return File(bytes, "text/html", "TablaSimbolos.html");
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }
        }

        [HttpGet("DownloadErrorTable")]
        public IActionResult DownloadErrorTable()
        {
            if (string.IsNullOrEmpty(TablaErrores))
            {

                return BadRequest(new { error = "No hay un reporte disponible" });
            }
            Console.WriteLine(TablaErrores);
            string nameFile = "TablaErrores.html";
            byte[] nameByte = System.Text.Encoding.UTF8.GetBytes(TablaErrores);
            return File(nameByte, "text/html", nameFile);
        }


    }
}