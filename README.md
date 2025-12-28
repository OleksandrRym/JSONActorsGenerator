# 🎬 JSON Actor Generator (Spring AI + Ollama)
**Fully represent how spring Ai work with model**      
Easy for beginers 😌

### 🏛 Architecture Schema
![Alt text](Schema.png)


### ⏩ Endpoint
```
GET /actors
```

### ⏪️ Response:
```
[
  {
    "actor": "Leonardo DiCaprio",
    "movies": [
      "Inception",
      "Titanic",
      "The Revenant"
    ]
  },
  {
    "actor": "Scarlett Johansson",
    "movies": [
      "Lucy",
      "Marriage Story",
      "Black Widow"
    ]
  }
]

```

## 📦 Installation
```
https://github.com/OleksandrRym/JSONActorsGenerator.git
ollama pull ollama2:7b
ollama run llama2:7b  
im the program -> run main class
