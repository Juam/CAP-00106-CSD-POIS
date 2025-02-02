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
        { "mensaje": "Itinerario no encontrado" }
        """

    Scenario: Encontrar el punto de interes mas cercano a mi ubicacion actual de la categoria heladeria
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un GET a "/categoria/heladeria/pois?latitud=-34.58791299400180&longitud=-58.423084840220"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        [
            {
                "latitud": -34.58791299400182,
                "longitud": -58.423084840222,
                "nombre": "Rapa nui",
                "descripcion": "Una rica heladeria",
                "categoria": "heladeria"
            }
        ]
        """

    Scenario: Encontrar los puntos de interes mas cercano a mi ubicacion actual que se encuentran a una distancia de 0.004 de la categoria heladeria
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un GET a "/categoria/heladeria/pois?latitud=-34.58791299400180&longitud=-58.423084840220&distancia=0.004"
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        [
            {
                "latitud": -34.58791299400182,
                "longitud": -58.423084840222,
                "nombre": "Rapa nui",
                "descripcion": "Una rica heladeria",
                "categoria": "heladeria"
            }
        ]
        """

    Scenario: Quiero poder armar un submapa con los puntos de interes Rapa nui y Buenos aires verde
        Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
        When el cliente hace un POST a "/submapa" con contenido
        """
        {
            "nombre": "Mi submapa",
            "pois": [
                        {
                            "nombre": "Rapa nui"
                        },
                        {
                            "nombre": "Buenos aires verde"
                        }
                    ]
        }
        """
        Then recibe la respuesta con codigo de estado 200 y contenido
        """
        {
            "id": 1,
            "nombre": "Mi submapa",
            "pois": [
                        {
                            "latitud": -34.58791299400182,
                            "longitud": -58.423084840222,
                            "nombre": "Rapa nui",
                            "descripcion": "Una rica heladeria",
                            "categoria": "heladeria"
                        },
                        {
                            "latitud": -34.58428917744298,
                            "longitud": -58.43766774433044,
                            "nombre": "Buenos aires verde",
                            "descripcion": "Un restaurant verde",
                            "categoria": "restaurant"
                        }
                    ]
        }
        """
    Scenario: Quiero poder guardar las coordenadas -34.59791299400182 y -58.433084840222 del sitio de interes Rapa nui 2
            Given el sistema tiene registrado Rapa nui, Freddo y Buenos aires verde
            When el cliente hace un POST a "/poi" con contenido
            """
            {
                "latitud": -34.59791299400182,
                "longitud": -58.433084840222,
                "nombre": "Rapa nui 2",
                "descripcion": "Una rica heladeria 2",
                "categoria": "heladeria"
            }
            """
            Then recibe la respuesta con codigo de estado 200 y contenido
            """
            {
                "latitud": -34.59791299400182,
                "longitud": -58.433084840222,
                "nombre": "Rapa nui 2",
                "descripcion": "Una rica heladeria 2",
                "categoria": "heladeria"
            }
            """