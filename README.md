# web-dist
WEB DIST PROJECT 5TWIN3
## 👺 UPDATE ! !
Our link:
[GitHub Link](https://github.com/y-essine/web-dist)
(old: https://github.com/liqili/spring-microservice-oauth2-keycloak-starter)
_______________________________________________

## 👌 TUTORIAL
Tuto : Comment faire fonctionner un projet Keycloak, Eureka, Spring Boot, et PostgreSQL
https://github.com/y-essine/web-dist

1. Activer WSL 2, Installer le noyau Linux WSL 2 Ubuntu-20.04 :
   
   (Powershell): `wsl --install; wsl --install -d Ubuntu-20.04; wsl --update`

2. Installez Docker Desktop, puis ouvrez-le. Si WSL 2 fonctionne correctement, Docker fonctionnera correctement

3. intégrer Docker avec WSL (Windows Subsystem for Linux): 

   (Powershell): `wsl --set-default Ubuntu-20.04`
Redémarrez Docker Desktop, puis ouvrez le terminal Ubuntu dans Windows et exécutez la commande docker -v.

4. Clone and build: (Terminal Ubuntu WSL): 
-  `mkdir gits && cd gits;` pour creer un nouveau dossier
- `git clone https://github.com/y-essine/web-dist`
- `cd web-dist`
- `ip addr show `
- Copiez l'adresse comme indiqué dans la capture d'écran.
- `code .`
- Remplacez les adresses IP trouvées dans le fichier docker-compose.yml par votre propre adresse.
- `sudo chown -R 200:200 /nexus-data`
- `docker-compose up -d nexus --build`
- Wait for nexus to startup
- `docker-compose up --build`

Vous devez attendre un moment, puis dans votre navigateur, accédez à http://(adresse IP):8080/api/consume. Une page de connexion s'ouvrira.

Créez un compte administrateur, consulter la page d'administration Keycloak en utilisant http://(adresse IP):18080/ et s'inscrire en tant qu'admin.

## Fetch access token and refresh token from keycloak server
Post a request to get an access token:

`POST http://localhost:18080/auth/realms/spring-micro-main/protocol/openid-connect/token`  
 `Content-Type: application/x-www-form-urlencoded`
 
 `&client_id=spring-micro-gateway&username=dev&password=123&grant_type=password&client_secret=**********`
