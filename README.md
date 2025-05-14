# JekooMarket
jekoomarket/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── jekoomarket/
│       │           ├── JekooMarketApplication.java     # Classe principal
│       │
│       │           ├── controller/                     # Controladores MVC
│       │           │   ├── JekUsuarioController.java
│       │           │   ├── JekProdutoController.java
│       │           │   └── JekPedidoController.java
│       │
│       │           ├── model/                          # Entidades JPA
│       │           │   ├── JekUsuario.java
│       │           │   ├── JekProduto.java
│       │           │   └── JekPedido.java
│       │
│       │           ├── repository/                     # Interfaces JPA
│       │           │   ├── JekUsuarioRepository.java
│       │           │   ├── JekProdutoRepository.java
│       │           │   └── JekPedidoRepository.java
│       │
│       │           ├── service/                        # Regras de negócio
│       │           │   ├── JekUsuarioService.java
│       │           │   ├── JekProdutoService.java
│       │           │   └── JekPedidoService.java
│       │
│       │           └── security/                       # Spring Security
│       │               ├── JekooSecurityConfig.java
│       │               └── JekooUserDetailsService.java
│
│       └── resources/
│           ├── static/                                # Arquivos estáticos (CSS, JS, imagens)
│           │   ├── css/
│           │   ├── js/
│           │   └── img/
│           │
│           ├── templates/                             # Páginas Thymeleaf
│           │   ├── jek-home.html
│           │   ├── jek-login.html
│           │   ├── jek-cadastro.html
│           │   ├── jek-produtos.html
│           │   ├── jek-detalhes-produto.html
│           │   ├── jek-carrinho.html
│           │   ├── jek-pedido.html
│           │   └── jek-erro.html
│           │
│           └── application.properties                 # Configuração do Spring Boot
│
├── .gitignore
├── README.md
└── pom.xml                                            # Gerenciador Maven
