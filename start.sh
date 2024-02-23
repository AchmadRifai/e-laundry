docker-compose pull
docker-compose up --force-recreate --build -d
sleep 1
docker system prune -f -a
docker volume prune -f