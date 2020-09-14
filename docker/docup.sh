#!/usr/bin/env bash

# Run docker stack deploy -c stack.yml postgres (or docker-compose -f stack.yml up), 
# wait for it to initialize completely, and visit 
# http://swarm-ip:7000, http://localhost:7000, or http://host-ip:7000 (as appropriate).

# docker stack deploy -c stack.yml postgres
# docker-compose -f stack.yml up
docker-compose up -d

