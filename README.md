# web-dist
WEB DIST PROJECT 5TWIN3
## 👺 UPDATE ! !
BADELT EL REPO EL ORIGINAL B REPO EL PROJET MTE3NA:
[GitHub Link](https://github.com/y-essine/web-dist)

(old: https://github.com/liqili/spring-microservice-oauth2-keycloak-starter)

_______________________________________________

## 👌 TUTORIAL
Chabeb tuto saghroun kifech tkhaddem projet keycloak eureka springboot postgres:
https://github.com/y-essine/web-dist

1. Tkhaddem el WSL2 aal windows, soboulou el Ubuntu-20.04 :
   
   (Powershell): `wsl --install; wsl --install -d Ubuntu-20.04; wsl --update`

   bech nabdew lkol kif kif ;  twali tnajem thel terminal Ubuntu kima fel capture 

3. Tsob docker desktop w thellou; ken el wsl2 mchetlek mrigla el docker yemchi mrigel

4. T'integri docker aal wsl: 

   (Powershell): `wsl --set-default Ubuntu-20.04`
Restarti el docker desktop baadika 7el el terminal Ubuntu aal windows w ekteb docker -v normalement yaatik el version w c bon integré

5. Clone and build: (Terminal Ubuntu WSL): 
-  `mkdir gits && cd gits;` ( creati dossier jdid bech tecloni fih)
- `git clone https://github.com/y-essine/web-dist`
- `cd web-dist`
- `ip addr show `
- tcopi el address eli fel terminal hayka fel capture
- `code .`
- badel el ips (normalement tal9ahom 10.0.0.7) eli fel docker-compose.yml bel ip edhika kima fel capture
- `find . -name "mvnw" -exec chmod +x {} \;`
** el commande edhika taati write permissions lel scripts maven
- `docker-compose up --build`

i kahaw tokood testana barcha taw lin yrakah jawou baadika
ki ykamel thel docker desktop talka kol chay running w 
temchi l nafs l ip aal navigateur kima lien hedha `http://`(ip)`:8080/api/consume`
tethallek login page w kol chay yemchi.

theb todkhol page admin keycloak w taamel compte: `http://`(ip)`:18080/` b compte admin/admin

## Fetch access token and refresh token from keycloak server
Post a request to get an access token:

`POST http://localhost:18080/auth/realms/spring-micro-main/protocol/openid-connect/token`  
 `Content-Type: application/x-www-form-urlencoded`
 
 `&client_id=spring-micro-gateway&username=dev&password=123&grant_type=password&client_secret=**********`
