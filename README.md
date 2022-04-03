# Intergiciel


# Installation

- docker 
- npm
- vue

# Démarrer le docker-compose

Dans un terminal, placez-vous dans le dossier Intergiciel et tapez la commande suivante :
```docker-compose -p Intergiciel up --build```

La commande va lancer notre docker-compose qui va créer la stack. On retrouve :
- zookeeper sur le port 2181
- kafka sur le port 9092
- postgre sur le port 5432

# Démarrer le projet
  ## Back
  
  Ouvrez le dossier back dans un IDE Java puis lancez le Main.  
  Le remplissage de la BDD va se produire tous les 30min depuis l'API https://api.covid19api.com/summary.  
  
  Pour récupérer les données en tant qu'utilisateur, il vous est possible de tester les routes créées depuis postman.  
  
  > http://localhost:8080/global : Retourne les valeurs globales du Covid19.  
  > http://localhost:8080/country : Retoune les valeurs du Covid19 pour un pays souhaité.  
  > http://localhost:8080/confirmedAvg : Retourne une moyenne des cas confirmés du Covid19.  
  > http://localhost:8080/deathsAvg : Retourne une moyenne des décès du Covid19.  
  > http://localhost:8080/countriesDeathsPercent : Retourne le pourcentage de décès par rapport aux cas confirmés.  
  > http://localhost:8080/export : Retournes un export des données de la base en XML.  
  
  ## Front
  
  Placez-vous dans le dossier front et tapez la commande suivante dans un terminal :
  ```
  npm install
  npm run serve
  ```
  
  Le front de notre application va se lancer sur un des ports de votre ordinateur.  
  Dans votre navigateur, tapez : localhost:{port}.  
  Vous arrivez sur le front et vous pouvez maintenant appeler la route que vous souhaitez en appuyant sur le bouton de votre choix dans chacune des cartes.   
  
   ## Crédits
   
   RIBAUT THOMAS : https://github.com/Dopey990
   DEREZE Alexandra : https://github.com/Alex221100
   
  
