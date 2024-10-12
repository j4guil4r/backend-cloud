const Evaluacion = require('../models/Evaluacion');

exports.crearEvaluacion = async (req, res) => {
  try {
    const nuevaEvaluacion = new Evaluacion(req.body);
    await nuevaEvaluacion.save();
    res.status(201).json(nuevaEvaluacion);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.obtenerEvaluaciones = async (req, res) => {
  try {
    const evaluaciones = await Evaluacion.find().populate('notas');
    res.status(200).json(evaluaciones);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
