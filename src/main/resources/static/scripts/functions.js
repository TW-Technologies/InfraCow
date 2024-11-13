/* Mudar Imagem do Input de Arquivos*/
document.getElementById('arquivoInput').addEventListener('change', function(event) {
    const file = event.target.files[0];  // Pega o arquivo de imagem selecionado

    if (file) {
        const reader = new FileReader();

        reader.onload = function(e) {
            // Alterando o 'src' da tag <img> com a imagem carregada
            document.getElementById('imgInput').src = e.target.result;
            document.getElementById('imgInput').style.width = '100%';
        };

        reader.readAsDataURL(file); // Lê o arquivo como uma URL de dados
    }
});