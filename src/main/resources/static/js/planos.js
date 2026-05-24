const inNome = document.querySelector("#inNome");
const inCat = document.querySelector("#inCat");
const inFreq = document.querySelector("#inFreq");
const inValor = document.querySelector("#inValor");
const inStatusPlano = document.querySelector("#inStatusPlano");
const tabelaPlanos = document.querySelector("#tabelaPlanos");
const frm = document.querySelector("form");

if (!frm || !tabelaPlanos) {
    console.error("Elementos do formulário ou da tabela de planos não foram encontrados.");
}

if (frm) {
    frm.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nome = inNome.value;
        const categoria = inCat.value;
        const freq = inFreq.value;
        const valor = inValor.value;
        const statusPlano = inStatusPlano.value;

        try {
            await Api.registrarPlano({
                nome,
                categoria,   // ← campo correto
                valor: parseFloat(valor),
                ativo: statusPlano === "Ativo"
            });
            frm.reset();
        } catch (error) {
            alert(error?.message || "Erro ao registrar plano");
        }
    });
}

async function getPlanos() {
    try {
        const planos = await Api.getPlanos();
        const lista = planos.content ?? [];

        let tabHtml = `
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Valor</th>
                </tr>
            </thead>
            <tbody>
        `;

        for (const plano of lista) {
            tabHtml += `
                <tr>
                    <td>${plano.nome ?? ""}</td>
                    <td>${plano.categoria ?? plano.planoEscolhidoId ?? ""}</td>
                    <td>${plano.valor ?? ""}</td>
                </tr>
            `;
        }

        tabHtml += `</tbody>`;
        tabelaPlanos.innerHTML = tabHtml;
    } catch (error) {
        alert(error?.message || "Erro ao carregar planos");
    }
}

getPlanos();