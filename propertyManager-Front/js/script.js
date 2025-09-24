
const form = document.getElementById('form');
form.addEventListener('submit', registerUser);

function registerUser(e) {
    e.preventDefault();
    var userData = null;
    const dataF = new FormData(form)
    const username = dataF.get("username")
    const email = dataF.get("email")

    fetch("http://3.16.112.92:8080/user/add",
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username,
                email
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Error en la creación");
            }
            return response.json();
        })
        .then(data => {
            userData = data;
            console.log("User registered");
            window.location.href = `layers/user.html?id=${data.id}`;
        })
        .catch(err => {
            console.error("Error:", err);
        });




}