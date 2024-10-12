from fastapi import FastAPI, HTTPException
import requests

app = FastAPI()

# URLs de los microservicios
ESTUDIANTES_URL = "http://estudiantes_service:8000"
CURSOS_URL = "http://cursos_service:8080"
EVALUACIONES_URL = "http://evaluaciones_service:3000"


@app.get("/recuperar_datos")
def recuperar_datos(estudiante_id: str):
    # Obtener datos del estudiante
    estudiante_response = requests.get(f"{ESTUDIANTES_URL}/estudiantes/{estudiante_id}")
    if estudiante_response.status_code != 200:
        raise HTTPException(status_code=estudiante_response.status_code, detail="Error obteniendo datos del estudiante")
    
    estudiante_data = estudiante_response.json()

    # Obtener los cursos en los que está inscrito el estudiante
    cursos_response = requests.get(f"{CURSOS_URL}/cursos?estudiante_id={estudiante_id}")
    if cursos_response.status_code != 200:
        raise HTTPException(status_code=cursos_response.status_code, detail="Error obteniendo datos de los cursos")
    
    cursos_data = cursos_response.json()

    # Obtener las evaluaciones del estudiante
    evaluaciones_response = requests.get(f"{EVALUACIONES_URL}/evaluaciones?estudiante_id={estudiante_id}")
    if evaluaciones_response.status_code != 200:
        raise HTTPException(status_code=evaluaciones_response.status_code, detail="Error obteniendo datos de las evaluaciones")

    evaluaciones_data = evaluaciones_response.json()

    # Combinar toda la información en una sola respuesta
    resultado = {
        "estudiante": estudiante_data,
        "cursos": cursos_data,
        "evaluaciones": evaluaciones_data
    }

    return resultado
