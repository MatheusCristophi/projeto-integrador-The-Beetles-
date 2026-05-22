const tabelaAlunos = document.querySelector("#tabelaAlunos")
try{
    const alunos = await getAlunos();
    
    let tabHtml =
     `<thead>
        <th scope="col">Nome</th>
        <th scope="col">Plano Escolhido</th>
        <th scope="col">Status</th>
        <th scope="col">Vencimento</th>
    </thead>
    <tbody>`

    for(aluno of alunos){
        tabHtml += 
        `<tr>
            <td>${aluno.nome}</td>
            <td>${aluno.planoEscolhidoId}</td>
            <td>${aluno.status}</td>
            <td>${aluno.dataVencimento}</td>
        </tr>`    
    }
    tabHtml += `</tbody>`
    tabelaAlunos.innerHTML = tabHtml
} catch (error){
    alert("error.message")
}