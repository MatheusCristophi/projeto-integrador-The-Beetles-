const tabelaPagamentos = document.querySelector("#tabelaPagamentos")
async function getPagamentos() {
    try {
        const Pagamentos = await Api.getPagamentos();
        const lista = Pagamentos.content ?? [];

        let tabHtml =
            `<thead>
                <th scope="col">Nome</th>
                <th scope="col">Plano Escolhido</th>
                <th scope="col">Status</th>
                <th scope="col">Vencimento</th>
            </thead>
            <tbody>`
            ;

        for (const aluno of lista) {
            tabHtml += `
                <tr>
                    <td>${aluno.nome ?? ""}</td>
                    <td>${aluno.planoEscolhidoId ?? "Nenhum"}</td>
                    <td>${aluno.status ?? ""}</td>
                    <td>${aluno.dataVencimento ?? ""}</td>
                </tr>
            `;
        }

        tabHtml += `</tbody>`;
        tabelaPagamentos.innerHTML = tabHtml;
    } catch (error) {
        alert(error?.message || "Erro ao carregar Pagamentos");
    }
}
getPagamentos()