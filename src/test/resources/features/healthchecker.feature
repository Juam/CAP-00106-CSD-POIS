Feature: Verificacion de aplicación levantada

    Scenario: La aplicacion esta levantada y respondiendo
        Given la aplicacion está levantada
        When el cliente hace un GET a "/ping"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        {
            "mensaje": "pong"
        }
        """

    Scenario: Encontrar todos los puntos de interes de la categoria heladeria
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un GET a "/categoria/heladeria/pois"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        [
            {
                "latitud": -34.58791299400182,
                "longitud": -58.423084840222,
                "nombre": "Rapa nui",
                "descripcion": "Una rica heladeria",
                "categoria": "heladeria"
            },
            {
                "latitud": -34.58958675108932,
                "longitud": -58.42795175118532,
                "nombre": "Freddo",
                "descripcion": "Otra heladeria",
                "categoria": "heladeria"
            }
        ]
        """

    Scenario: Encontrar todos los puntos de interes de la categoria restaurant
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un GET a "/categoria/restaurant/pois"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        [
            {
                "latitud": -34.58428917744298,
                "longitud": -58.43766774433044,
                "nombre": "Buenos aires verde",
                "descripcion": "Un restaurant verde",
                "categoria": "restaurant"
            }
        ]
        """

    Scenario: Encontrar todos los puntos de interes de la categoria pizzeria
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un GET a "/categoria/pizzeria/pois"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        []
        """

    Scenario: Mostrar el itinerario Fiesta 1
        Given el sistema tiene registrado distintos itinerarios
        When el cliente hace un GET a "/itinerario/fiesta1"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        {
            "nombre": "Fiesta1",
            "descripcion": "Almuerzo y postre",
            "listaDePois": [
                            {
                                "latitud": -34.58428917744298,
                                "longitud": -58.43766774433044,
                                "nombre": "Buenos aires verde",
                                "descripcion": "Un restaurant verde",
                                "categoria": "restaurant"
                            },
                            {
                                "latitud": -34.58791299400182,
                                "longitud": -58.423084840222,
                                "nombre": "Rapa nui",
                                "descripcion": "Una rica heladeria",
                                "categoria": "heladeria"
                            },
                            {
                                "latitud": -34.588097427250915,
                                "longitud": -58.430480822197964,
                                "nombre": "Polaris Omakase",
                                "descripcion": "Un bar",
                                "categoria": "bar"
                            }
                          ]
        }
        """

    Scenario: Mostrar mensaje de error con el itinerario Fiesta 2
        Given el sistema tiene registrado distintos itinerarios
        When el cliente hace un GET a "/itinerario/fiesta2"
        Then recibe la respuesta con codigo de estado 404 y contenido
        """
        { "mensaje": "Itinerario no encontrado1" }
        """