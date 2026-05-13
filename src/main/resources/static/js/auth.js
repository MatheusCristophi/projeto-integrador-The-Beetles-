const email = document.querySelector.value("#inEmail");
const senha = document.querySelector.value("#inSenha");

const frm = document.querySelector("form")
frm.addEventListener("submit", (e)=>{
    const response = fetch('/auth/login', {
        method:'POST',
        headers: { 'Content-Type' : 'application/json' },
        body: JSON.stringify({email,senha})
    })
})