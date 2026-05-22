const tabelaPagamentos = document.querySelector("#tabelaPagamentos")
try{
    const pagamentos = await getPagamentos();
    
    let tabHtml =
     `<thead>
        <th scope="col">Aluno</th>
        <th scope="col">Valor Cobrado</th>
        <th scope="col">Status</th>
        <th scope="col">Data</th>
    </thead>
    <tbody>`

    for(pagamento of pagamentos){
        tabHtml += 
        `<tr>
            <td>${pagamento.aluno.nome}</td>
            <td>${pagamento.valorCobrado}</td>
            <td>${pagamento.statusPagamento}</td>
            <td>${pagamento.dataConfirmacao}</td>
        </tr>`    
    }
    tabHtml += `</tbody>`
    tabelaPagamentos.innerHTML = tabHtml
} catch (error){
    alert("error.message")
}