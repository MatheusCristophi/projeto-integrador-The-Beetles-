const inNome = document.querySelector("#inNome");
const inPlano = document.querySelector("#inPlano");
const inStatus = document.querySelector("#inStatus");

const frm = document.querySelector("frm");
frm.addEventListener("submit", (e)=>{
    e.preventDefault();

    const nome = inNome.value;
    const plano = inPlano.value;
    const status = inStatus.value;

    try{
        Api.registrarAluno({nome, plano, status});
    } catch (error){
        alert(error.message);
    }

})