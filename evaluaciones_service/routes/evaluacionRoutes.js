const express = require('express');
const { crearEvaluacion, obtenerEvaluaciones } = require('../controllers/evaluacionController');

const router = express.Router();

/**
 * @swagger
 * /evaluaciones:
 *   get:
 *     summary: Obtiene todas las evaluaciones
 *     description: Retorna una lista de todas las evaluaciones registradas
 *     responses:
 *       200:
 *         description: Lista de evaluaciones
 *         content:
 *           application/json:
 *             schema:
 *               type: array
 *               items:
 *                 type: object
 *                 properties:
 *                   id:
 *                     type: string
 *                     description: ID de la evaluación
 *                   nombre:
 *                     type: string
 *                     description: Nombre de la evaluación
 *                   fecha:
 *                     type: string
 *                     description: Fecha de la evaluación
 */
router.get('/', obtenerEvaluaciones);

/**
 * @swagger
 * /evaluaciones:
 *   post:
 *     summary: Crea una nueva evaluación
 *     description: Crea una nueva evaluación con los datos proporcionados
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nombre:
 *                 type: string
 *                 description: Nombre de la evaluación
 *               fecha:
 *                 type: string
 *                 description: Fecha de la evaluación
 *     responses:
 *       201:
 *         description: Evaluación creada exitosamente
 */
router.post('/', crearEvaluacion);

module.exports = router;
