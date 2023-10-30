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

    Scenario: Encontrar todos los puntos de interes de una categoria de la categoria heladeria
        Given el sistema tiene registrado Rapa nui y Freddo
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

    Scenario: Encontrar todos los puntos de interes de una categoria de la categoria pizzeria
        Given el sistema tiene registrado Rapa nui y Freddo
        When el cliente hace un GET a "/categoria/pizzeria/pois"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        []
        """