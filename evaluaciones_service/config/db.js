const mongoose = require('mongoose');

// Reemplaza con tu URI de MongoDB
const uri = 'mongodb://3.234.197.222:3000/MS_Evaluaciones';

// Función para conectar a la base de datos
const connectDB = async () => {
    try {
        await mongoose.connect(uri, {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log('Conexión a MongoDB exitosa');
    } catch (error) {
        console.error('Error de conexión a MongoDB:', error);
        process.exit(1); // Termina la app si no se puede conectar
    }
};

module.exports = connectDB;
