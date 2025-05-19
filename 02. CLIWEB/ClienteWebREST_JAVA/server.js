const express = require('express');
const path=require('path');
const fetch = (...args) => import('node-fetch').then(({ default: fetch }) => fetch(...args));
const app = express();

app.use(express.json()); // Importante para leer JSON del body
app.use(express.static(__dirname)); 

const TARGET_URL = 'http://10.40.26.92:8080/ServidorRESTConversion/api/conversion';

app.post('/api/conversion', async (req, res) => {
    try {
        const response = await fetch(TARGET_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(req.body)
        });

        const data = await response.json(); // Puede lanzar si el servidor no responde JSON
        res.json(data);
    } catch (error) {
        console.error('Error al hacer fetch al servidor Java:', error);
        res.status(500).send('Error en el proxy');
    }
});

app.listen(3000, () => {
    console.log('Proxy corriendo en http://localhost:3000');
});
