const mongoose = require('mongoose');

const EvaluacionSchema = new mongoose.Schema({
    nombre: { type: String, required: true },
    nota: { type: Number, required: true },
    estudianteId: { type: mongoose.Schema.Types.ObjectId, ref: 'Estudiante', required: true },
    cursoId: { type: mongoose.Schema.Types.ObjectId, ref: 'Curso', required: true },
});

module.exports = mongoose.model('Evaluacion', EvaluacionSchema);
