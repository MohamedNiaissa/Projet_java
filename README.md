Projet_java

                                                                  Commandes de l'application
                                                                  
● Le but de cette application est de pouvoir créer, lister et faire combattre différents personnages
● Toutes les informations de base (archétype, nom, dégâts, points de vie, initiative) seront renseignés lors de la création du personnage
● La liste des personnages n'affichera que le nom et l'archétype. Un numéro sera également affiché, qui sera le numéro du personnage dans l'ordre de création
● Une commande permettra d'afficher les détails d'un personnage en entrant son numéro 
● Une commande pour supprimer un personnage de la liste
● Une commande permettra de faire combattre 2 personnages en entrant les 2 numéros correspondants. Cette commande créera une boucle qui fera attaquer les personnages l'un après l'autre jusqu'à ce que l'un deux soit mort
● Une commande permettra de lister les commandes possibles
● Une commande permettra également de sortir de l'application                                                                


                                                                    Déroulement d'un combat
                                                                    
● Un combat se déroulera de la manière suivante :
– Le personnage avec le niveau d'initiative le plus grand sera celui qui
commencera par attaquer
– Quand un personnage attaque, l'opposant encaisse les dégâts et réduit ses points de vie
– Si le personnage attaqué n'est pas mort, c'est à son tour d'appliquer les dégâts sur son adversaire
– Le combat continue ainsi de suite jusqu'à ce l'un des deux personnages voit ses points de vie passer en dessous de 0
– Pour chaque tour du combat, on indiquera par un message qui attaque et avec combien points de dégâts, qui est blessé et le niveau de points de vie mis à jour
– Le nom du personnage gagnant sera indiqué à la toute fin du combat          


                                                                    Archétypes de personnages


 Archétypes de personnages
• Le projet devra pouvoir faire combattre plusieurs archétypes de personnages
• L'archétype par défaut :
• Il possède un nom
• Il peut attaquer (possède un coefficient de dégâts)
• Il peut encaisser des dégâts (possède donc une quantité limitée de points de vie)
• Il peut initier le combat (possède une valeur d'initiative)
• D'autres archétypes existent et reprennent les fonctions de l'archétype par
défaut tout en possédant des capacités supplémentaires :
• Guerrier : possède un bouclier qui réduit les dégâts infligés d'une valeur constante
• Magicien : inflige des dégâts magiques se rajoutant aux dégâts de base, mais ces dégâts magiques réduisent de moitié après chaque attaque
• Voleur : possède une probabilité d'esquiver totalement une attaque, et possède également une probabilité d'infliger un coup critique qui doublera les dégâts de base



                                                              Story 1: Environnement de développement
                                                              
EN TANT qu'étudiant de la Coding Factory
JE VEUX pouvoir développer, exécuter et débugger du code Java AFIN DE tester les concepts abordés durant ce sprint
Definition of Done (Critères d'acceptation)
– Installation de la machine virtuelle Java (version la plus récente possible)
– Installation de l'environnement de développement IntelliJ(version la plus récente possible)
– Création d'un projet de type : Application Java (console) – Création d'une classe principale
– Affichage d'un message de type « Application has started » quand le projet est lancé
– Capacité a débuguer l’application.


                                                              Story 2: Menu de commandes
EN TANT qu'étudiant de la Coding Factory
JE VEUX créer un menu en ligne de commande
AFIN DE pouvoir contrôler mon application
Definition of Done (Critères d'acceptation)
– un menu en ligne de commande pouvoir naviguer et quitter mon application proprement.

                                                               Story 3 : Classe d'archétype par défaut
                                                               
EN TANT qu'étudiant de la Coding Factory
JE VEUX créer une première classe non statique
AFIN DE commencer à mettre en pratique les bases de la POO
Definition of Done (Critères d'acceptation)
– Création d'une classe pour l'archétype par défaut (Archetype)
– La classe possède des attributs private ou protected pour le nom, les dégâts, les points de vie et l'initiative
– La classe possède une méthode publique (getDamages) pour récupérer les dégâts/la force de frappe
– La classe possède une méthode publique (takeDamages) pour blesser le personnage (il reçoit des dégâts).
– La classe surcharge la méthode toString utilisée en Java pour afficher les informations du personnage




                                                            Story 4 : Création et affichage de personnages
EN TANT que client
JE VEUX modifier ma liste de commandes
AFIN DE pouvoir gérer la création d'un personnage
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour la création d'un personnage par défaut
– Ajout d'une liste pour stocker les personnages créés
– Ajout d'une commande pour lister les personnages créés (avec numéros des personnages affichés)
– Ajout d'une commande pour afficher les informations d'un personnage (le numéro du personnage est requis dans cette commande)




                                                            Story 5 : Combat entre 2 personnages
                                                            
                                                            
                                                            
EN TANT que client
JE VEUX pouvoir lancer un combat entre 2 personnages
AFIN DE simuler un combat entre 2 personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour lancer un combat entre 2 personnages sélectionnés dans la liste des personnages.
– Affichage des étapes du combat (dégâts, points de vie, numéro du tour, ...)
– Affichage du nom et type du gagnant


                                                            Story 6 : Création et utilisation du guerrier
                                                            
                                                            
EN TANT que client
JE VEUX pouvoir créer des guerrier AFIN DE gérer ma liste de personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour créer un guerrier
– Intégration de l'archétype du guerrier dans la liste des personnages
– Utilisation de guerriers dans un combat
– Création d'une classe spécifique pour le guerrier en utilisant l'héritage de l'archétype par défaut et si besoin redéfinir certaines méthodes publiques
– Ajout d'une propriété privée pour le bouclier (avec la méthode publique pour la récupérer). Le bouclier réduit d'une valeur constante les dégâts infligés. Si les dégâts infligés sont moins importants que la valeur du bouclier, le guerrier n'est donc pas blessé


                                                            Story 7 : Création et utilisation du magicien
                                                            
EN TANT que client
JE VEUX pouvoir créer des magicien AFIN DE gérer ma liste de personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour créer un magicien
– Intégration de l'archétype du magicien dans la liste des personnages
– Utilisation de magiciens dans un combat
– Création d'une classe spécifique pour le guerrier en utilisant l'héritage de l'archétype par défaut et si besoin redéfinir certaines méthodes publiques
– Ajout d'une propriété privée pour les dégâts magiques (avec la méthode publique pour les récupérer). Les dégâts magiques sont rajoutés aux dégâts de base, mais ces dégâts magiques sont réduits de moitié après chaque attaque. Les dégâts magiques sont réinitialisés à leur valeur d'origine au début de chaque combat


                                                            Story 8 : Création et utilisation du voleur
                                                            
EN TANT que client
JE VEUX pouvoir créer des voleurs AFIN DE gérer ma liste de personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour créer un voleur
– Intégration de l'archétype du voleur dans la liste des personnages
– Utilisation de voleurs dans un combat
– Création d'une classe spécifique pour le voleur en utilisant l'héritage de l'archétype par défaut et si besoin redéfinir certaines méthodes publiques
– Ajout d'une propriété privée pour l'esquive (et la méthode publique pour la récupérer). Un voleur possède une probabilité d'esquiver totalement une attaque.
– Ajout d'une propriété privée pour les dégâts critiques (et la méthode publique pour les récupérer).
Un voleur possède une probabilité d'appliquer des dégâts critiques. Dans ce cas, il double les dégâts. Les dégâts critiques ne peuvent pas être appliqués sur 2 attaques consécutives

  
                                                          Story 9 : Suppression d'un personnage
EN TANT que client
JE VEUX pouvoir supprimer un personnage
AFIN DE gérer ma liste de personages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour supprimer un personnage. Le numéro du personnage doit être renseigné. Une confirmation sera demandée avant suppression. Le personnage est supprimé de la liste avec un message indiquant son nom et son archétype



                                                           Story 10 : Interface de combat [BONUS]
                                                           
EN TANT qu'étudiant de la Coding Factory
JE VEUX remplacer les liens d'héritage par des liens d'interface
AFIN DE voir la mise en place et comprendre l'utilité des interfaces en POO
Definition of Done (Critères d'acceptation)
– Supprimer les liens d'héritage entre les classes et les remplacer par l'utilisation d'une interface de combat
– L'interface doit contenir les services pour appliquer les dégâts comme cela est fait dans chacune des classes d'archétypes
– Modifier la liste de personnages pour ne gérer qu'une liste d'objets de type interface




                                                          Story 11 : Création et utilisation du Mage Guerrier [BONUS]
                                                          
                                                          
EN TANT que client
JE VEUX pouvoir créer des Mage Guerrier AFIN DE gérer ma liste de personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour créer le personnage
– Intégration de l'archétype dans la liste des personnages
– Utilisation du personnage dans un combat
– Cette classe possède les capacités décrite dans les classes parent


                                                          Story 12 : Possibilité de combat multi-personnage NxN [BONUS]
                                                          
                                                          
EN TANT que client
JE VEUX pouvoir lancer un combat entre deux équipes de plusieurs
personnages
AFIN DE simuler un combat entre plusieurs personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour lancer un combat entre plusieurs personnages contre plusieurs personage
– Affichage des étapes du combat (dégâts, points de vie, numéro du tour, ...)
– Affichage du nom et type du gagnant



                                                          Story 13 : Gestion de fichier [BONUS]
EN TANT que client
JE VEUX charger et sauvegarder les personnages crée. AFIN DE simplifier ma gestion de personnages
Definition of Done (Critères d'acceptation)
– Ajout d'une commande pour sauvegarder les personnages dans un fichier – Ajout d'une commande pour charger les personnages d’un un fichier









