# 🪨📄✂️ Jogo Pedra, Papel e Tesoura

Um aplicativo Android simples, interativo e divertido desenvolvido inteiramente com **Kotlin** e **Jetpack Compose**. 

A proposta deste projeto é promover a interação presencial: cada amigo abre o aplicativo em seu próprio celular, ambos apertam o botão "Jogar" ao mesmo tempo e, após uma rápida animação de sorteio, comparam os resultados exibidos na tela para ver quem venceu!

## ✨ Funcionalidades

* **Sorteio Aleatório:** O aplicativo escolhe de forma 100% aleatória entre Pedra, Papel ou Tesoura.
* **Animação Visual:** Durante o sorteio, as imagens se alternam rapidamente na tela, criando um efeito de suspense antes de revelar o resultado final.
* **Prevenção de Cliques Múltiplos:** O botão "Jogar" é desativado durante a animação para evitar bugs ou sobreposição de sorteios.
* **Interface Moderna:** UI construída de forma declarativa usando Jetpack Compose.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
* **Assincronismo:** Kotlin Coroutines (para gerenciar o tempo de tela da animação de sorteio sem travar a interface principal).
* **IDE:** Android Studio

## 🚀 Como executar o projeto

Se você deseja clonar e rodar este projeto na sua máquina, siga os passos abaixo:

### Pré-requisitos
* Ter o **Android Studio** instalado.
* Um emulador configurado ou um smartphone Android físico com a *Depuração USB* ativada.

### Passo a Passo

1. Faça o clone deste repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)

2. Abra o projeto no Android Studio.

3. Importante: Certifique-se de adicionar três imagens na pasta app/src/main/res/drawable com os seguintes nomes (caso não estejam no repositório):

pedra.png (ou .jpg)
papel.png (ou .jpg)
tesoura.png (ou .jpg)

4. Aguarde o Gradle sincronizar todas as dependências do projeto.

5. Clique no botão verde de Run (Play) na barra superior do Android Studio para instalar o app no seu emulador ou dispositivo físico.
