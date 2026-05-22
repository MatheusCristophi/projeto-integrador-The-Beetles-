const inNome = document.querySelector("#inNome");
const inCat = document.querySelector("#inCat");
const inFreq = document.querySelector("#inFreq");
const inValor = document.querySelector("#inValor");
const inStatusPlano = document.querySelector("#inStatusPlano");

const frm = document.querySelector("frm");
frm.addEventListener("submit", (e)=>{
    e.preventDefault();

    const nome = inNome.value;
    const cat = inCat.value;
    const freq = inFreq.value;
    const valor = inValor.value;
    const statusPlano = inStatusPlano.value;


    try{
        Api.registrarPlano({nome, plano, freq, valor, statusPlano});
    } catch (error){
        alert(error.message);
    }

})