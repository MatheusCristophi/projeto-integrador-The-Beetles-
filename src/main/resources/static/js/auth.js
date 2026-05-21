
const frm = document.querySelector("form")

async function auth(e){
    e.preventDefault();
    const email = document.querySelector("#inEmail").value;
    const senha = document.querySelector("#inSenha").value;

    const response = await fetch("/auth/login", {
        method:"POST",
        headers: {"Content-type": "application/json"},
        body: JSON.stringify({email,senha})
    });
    const body = await response.json();
    if(!response.ok){
        alert(body.message);
        return; 
    }
    const token = body.token;

    localStorage.setItem("token", token);
    const payload = JSON.parse(atob(token.split(".")[1]))
    const role = payload.role;

    if(role=="ROLE_ADMIN"){
        window.location.href="/adminDashboard.html"
    } else {
        window.location.href="/alunoDashboard.html"
    }

}

frm.addEventListener("submit", auth)


