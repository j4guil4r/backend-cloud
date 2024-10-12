const express = require('express');
const { crearNota, obtenerNotas } = require('../controllers/notaController');

const router = express.Router();

/**
 * @swagger
 * /notas:
 *   get:
 *     summary: Obtiene todas las notas
 *     description: Retorna una lista de todas las notas registradas
 *     responses:
 *       200:
 *         description: Lista de notas
 *         content:
 *           application/json:
 *             schema:
 *               type: array
 *               items:
 *                 type: object
 *                 properties:
 *                   id:
 *                     type: string
 *                     description: ID de la nota
 *                   estudiante:
 *                     type: string
 *                     description: Nombre del estudiante
 *                   nota:
 *                     type: number
 *                     description: Nota obtenida por el estudiante
 */
router.get('/', obtenerNotas);

/**
 * @swagger
 * /notas:
 *   post:
 *     summary: Crea una nueva nota
 *     description: Crea una nueva nota con los datos proporcionados
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               estudiante:
 *                 type: string
 *                 description: Nombre del estudiante
 *               nota:
 *                 type: number
 *                 description: Nota obtenida por el estudiante
 *     responses:
 *       201:
 *         description: Nota creada exitosamente
 */
router.post('/', crearNota);

module.exports = router;
