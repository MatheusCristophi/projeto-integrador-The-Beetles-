const tabelaAlunos = document.querySelector("#tabelaAlunos")

async function getAlunos() {
    try {
        const alunos = await Api.getAlunos();
        const lista = alunos.content ?? [];

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
        tabelaAlunos.innerHTML = tabHtml;
    } catch (error) {
        alert(error?.message || "Erro ao carregar alunos");
    }
}
getAlunos();