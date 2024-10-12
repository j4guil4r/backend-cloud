#!/bin/bash

echo "Iniciando microservicios del backend"
echo "--------------------------------------"

#Levantar los microservicios en segundo plano
docker-compose up -d

echo ""
echo "Microservicios en ejecución:"
echo "--------------------------------------"
docker ps
