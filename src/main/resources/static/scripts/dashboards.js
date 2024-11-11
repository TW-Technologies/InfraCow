/* DASHBOARD - BARRAS - Gráfico Anual  */
const graficoBarrasMortes = document.getElementById('graficoBarrasMortes');

new Chart(graficoBarrasMortes, {
    type: 'bar',
    data: {
        labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho','Julho','Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'  ],
        datasets: [{
            label: 'Casos Positivos',
            data: [12, 19, 3, 5, 2, 3],
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,

        maintainAspectRatio: false,
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Quantidade de Animais Contaminados por Mês',
            }
        }

    }
});

/* DASHBOARD - PIZZA - Relação Total  */
const graficoPizzaRelacaoTotal = document.getElementById('graficoPizzaRelacaoTotal');

new Chart(graficoPizzaRelacaoTotal, {
    type: 'pie',
    data: {
        labels: ['Animais Infectados', 'Animais Saudáveis', ],
        datasets: [{
            label: 'Quantidade',
            data: [50, 60],
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Relação Total Animais Contaminados - 10/11/2024'
            }
        }
    },
});
