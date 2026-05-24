const inNome = document.querySelector("#inNome");
const inStatus = document.querySelector("#inStatus");
const selectPlanos = document.querySelector("#planos");

const frm = document.querySelector("form");

async function getPlanosNome() {
    try {
        const planos = await Api.getPlanos();
        const lista = planos.content ?? [];
        let options = ``;
        for (const plano of lista) {
            options += `
                <option value="${plano.planoId}">${plano.nome}
                </option>
                `
        }
        selectPlanos.innerHTML = options
    } catch (error) {
        alert(error?.message || "Erro ao carregar planos");
    }

}

frm.addEventListener("submit", (e) => {
    e.preventDefault();

    const nome = inNome.value;
    const plano = selectPlanos.value;
    const status = inStatus.value;

    try {
        Api.registrarAluno({ nome, plano, status });
    } catch (error) {
        alert(error.message);
    }

})

getPlanosNome();