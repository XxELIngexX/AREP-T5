const form = document.getElementById("property-form")
form.addEventListener('submit', addProperty)

const userID = new URLSearchParams(window.location.search).get('id');

async function addProperty(e) {
    e.preventDefault();

    const dataF = new FormData(form)
    const address = dataF.get("address")
    const price = dataF.get("price")
    const size = dataF.get("size")
    const description = dataF.get("description")
    let user;

    await fetch(`http://3.16.112.92:8080/user/${userID}`,
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }

        }

    ).then(resp => {
        if (!resp.ok) {
            throw new Error("error")
        }
        return resp.json()
    })
        .then(data => {
            user = data.id

        })
    console.log("se encontro el usuario")
    console.log(user)

    await fetch(`http://3.16.112.92:8080/property/add`, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            address, price, size, description, user
        })
    })
    .then(resp => {
        if (!resp.ok){
            throw new Error("error")
        }
        return resp.json()
    })
    .then (data =>{
        console.log(data)
        window.location.href = `user.html?id=${userID}`
    })

}