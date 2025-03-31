'use client';
import { Editor } from '@monaco-editor/react';
import { useState } from 'react';

const API_URL = 'http://localhost:5116';

export default function Home() {
  const [code, setCode] = useState<string>('');
  const [output, setOutput] = useState<string | string[]>('');
  const [fileName, setFileName] = useState<string>('ArchivoGoLight.glt');

  const handleExecute = () => {
    fetch(`${API_URL}/Compile`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ code }),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((data) => {
            throw new Error(data.error || 'Unknown error');
          });
        }
        return response.json();
      })
      .then((data) => {
        setOutput(data.result);
      })
      .catch((error) => {
        setOutput(`Error: ${error.message}`);
      });
  };


  const handleCreateFile = () => {
    setCode(''); 
    setFileName('ArchivoGLT.glt'); 
    alert('Archivo nuevo creado.');
  };

  const handleOpenFile = () => {
    const input = document.createElement('input');
    input.type = 'file';
    input.accept = '.glt';
    input.onchange = (event: Event) => {
      const file = (event.target as HTMLInputElement).files?.[0];

      if (!file) {
        alert('No se seleccionó ningún archivo.');
        return;
      }

      const reader = new FileReader();
      reader.onload = (e) => {
        setCode(e.target?.result as string);
        setFileName(file.name);
        alert(`Archivo "${file.name}" abierto correctamente.`);
      };
      reader.readAsText(file);
    };
    input.click();
  };
  

  const handleSaveFile = () => {
    if (!code.trim()) {
      alert('No hay contenido para guardar.');
      return;
    }

    const blob = new Blob([code], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);

    const a = document.createElement('a');
    a.href = url;
    a.download = fileName;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);

    URL.revokeObjectURL(url);
    alert(`Archivo "${fileName}" guardado correctamente.`);
  };

  const handleShowErrors = () => {
    fetch(`${API_URL}/Compile/DownloadErrorTable`)
      .then((response) => {
        if (!response.ok) {
          return response.json().then((data) => {
            throw new Error(data.error || 'Error desconocido al obtener el reporte de errores');
          });
        }
        return response.blob();
      })
      .then((blob) => {
        const url = URL.createObjectURL(blob);
  
        const a = document.createElement('a');
        a.href = url;
        a.download = 'ReporteErrores.html'; 
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
  
        URL.revokeObjectURL(url);
      })
      .catch((error) => {
        alert(`Error: ${error.message}`);
      });
  };
  
  

  const handleShowSymbolTable = () => {
    fetch(`${API_URL}/Compile/GenerateSymbolTable`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ code }),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((data) => {
            throw new Error(data.error || 'Error desconocido al obtener la tabla de símbolos');
          });
        }
        return response.blob();
      })
      .then((blob) => {

        const url = URL.createObjectURL(blob);

        const a = document.createElement('a');
        a.href = url;
        a.download = 'TablaSimbolos.html'; 
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
  
        URL.revokeObjectURL(url);
      })
      .catch((error) => {
        alert(`Error: ${error.message}`);
      });
  };
  
  
  
  const handleShowAST = () => {
    fetch(`${API_URL}/Compile/ReporteAST`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ code }),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((data) => {
            throw new Error(data.error || 'Error desconocido al obtener AST');
          });
        }
        return response.text();
      })
      .then((svg) => {
        const blob = new Blob([svg], { type: 'image/svg+xml' });
  
        const url = URL.createObjectURL(blob);

        const a = document.createElement('a');
        a.href = url;
        a.download = 'AST.svg'; 
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
  

        URL.revokeObjectURL(url);
      })
      .catch((error) => {
        alert(`Error: ${error.message}`);
      });
  };
  
  

  return (
    <div className='flex flex-col items-center justify-center min-h-screen bg-gray-900 text-gray-100 p-4'>
      <div className='w-full max-w-6xl bg-gray-800 rounded-lg shadow-lg p-6 border border-gray-700'>
        <div className='flex justify-between mb-4'>
          <div className='flex space-x-2'>
            <button
              className='bg-teal-600 hover:bg-teal-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
              onClick={handleCreateFile}
            >
              Crear Archivo
            </button>
            <button
              className='bg-teal-600 hover:bg-teal-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
              onClick={handleOpenFile}
            >
              Abrir Archivo
            </button>
            <button
              className='bg-teal-600 hover:bg-teal-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
              onClick={handleSaveFile}
            >
              Guardar Archivo
            </button>
          </div>
          <button
            className='bg-green-500 hover:bg-green-600 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
            onClick={handleExecute}
          >
            EJECUTAR
          </button>
        </div>
        <h2 className='text-xl font-bold mb-2 text-white'>Editor:</h2>
        <Editor
          height='35vh'  
          defaultLanguage='javascript'
          theme='vs-dark'
          value={code}
          onChange={(value) => setCode(value || '')}
        />
        
        <div className='mt-4 bg-gray-700 p-4 rounded border border-gray-600'>
          <h2 className='text-xl font-bold mb-2 text-white'>Consola:</h2>
          <pre className='bg-gray-600 p-2 rounded text-green-200 overflow-auto h-[150px]'>  
            {output}
          </pre>
        </div>
        <div className='mt-4 flex space-x-2 justify-center'>
          <button
            className='bg-pink-600 hover:bg-pink-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
            onClick={handleShowErrors}
          >
            Reporte de Errores
          </button>
          <button
            className='bg-pink-600 hover:bg-pink-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
            onClick={handleShowSymbolTable}
          >
            Tabla de Símbolos
          </button>
          <button
            className='bg-pink-600 hover:bg-pink-700 text-gray-900 font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105'
            onClick={handleShowAST}
          >
            Reporte AST
          </button>
        </div>
  
      </div>
    </div>
  );
}