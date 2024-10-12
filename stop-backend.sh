#!/bin/bash

echo "Deteniendo microservicios del backend"
echo "--------------------------------------"

# Detener los microservicios
sudo docker-compose down

echo ""
echo "Microservicios detenidos y contenedores eliminados"
echo "--------------------------------------"

