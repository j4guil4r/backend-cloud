const mongoose = require('mongoose');

const notaSchema = new mongoose.Schema({
  estudianteId: { type: mongoose.Schema.Types.ObjectId, ref: 'Estudiante', required: true },
  cursoId: { type: mongoose.Schema.Types.ObjectId, ref: 'Curso', required: true },
  valor: { type: Number, required: true },
  fecha: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Nota', notaSchema);
