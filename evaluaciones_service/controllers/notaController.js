const Nota = require('../models/Nota');

exports.crearNota = async (req, res) => {
  try {
    const nuevaNota = new Nota(req.body);
    await nuevaNota.save();
    res.status(201).json(nuevaNota);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.obtenerNotas = async (req, res) => {
  try {
    const notas = await Nota.find().populate('estudianteId cursoId');
    res.status(200).json(notas);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
