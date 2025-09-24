const params = new URLSearchParams(window.location.search).get('id');

var userInfo;


function loadInfo() {
    fetch(`http://3.16.112.92:8080/user/${params}`,
        {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            },
        }
    )
        .then(response => {
            if (!response.ok) {
                throw new Error("no se cargo")
            }
            return response.json()
        })
        .then(data => {
            userInfo = data;

            // create wolcome message
            const bienvenida = document.getElementById("welcome")
            bienvenida.textContent = `welcome ${userInfo.username}`

            // list personal information
            var continer = document.getElementById("user-info")

            continer.innerHTML =
                `<p>ID: ${userInfo.id}</p>`
                + `<p>nombre: ${userInfo.username}</p>`
                + `<p>email: ${userInfo.email}</p>`

            //LIST PROPERTIES

            var property = document.getElementById("user-property")
            if (userInfo.properties.length > 0) {
                let tableHTML = `
            <h2>Propiedades</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>address</th>
                        <th>Desacription</th>
                        <th>price</th>
                        <th>modify</th>
                    </tr>
                </thead>
                <tbody>
        `;

                userInfo.properties.forEach(prop => {
                    tableHTML += `
                <tr>
                    <td>${prop.id}</td>
                    <td>${prop.address}</td>
                    <td>${prop.description}</td>
                    <td>${prop.price}</td>
                    <td><button class="update" data-id="${prop.id}">edit</button> <button class="delete" data-id="${prop.id}">delete</button> </td>

                </tr>
            `;
                });
                tableHTML += `</tbody></table>`;
                property.innerHTML = tableHTML;
                const updateBtn = document.querySelectorAll(".update");

                const deleteBtns = document.querySelectorAll(".delete")
                deleteBtns.forEach(btn => btn.addEventListener("click", deleteProduct))



            } else {
                property.innerHTML = `
                <h2>propiedades</h2>
                <p>No tiene propiedades.</p>`

            }
            const addBtn = document.createElement("button");
            addBtn.id = "addProperty";
            addBtn.textContent = "registrar una nueva propiedad";
            addBtn.addEventListener("click", addProperty);
            property.appendChild(addBtn);
        })
}
function addProperty() {
    window.location.href = `form.html?id=${userInfo.id}`;
}

function deleteProduct(e) {
    e.preventDefault();
    console.log("eliminando")
    const propertyId = e.target.getAttribute("data-id");
    fetch(`http://3.16.112.92:8080/property/delete/${propertyId}`,
        { method: "DELETE" }
    )
        .then(resp => {
            if (!resp.ok) {
                throw new Error("error")
            }
            window.location.reload();
        })
        .catch(err => console.error("error:", err))
}
window.addEventListener('DOMContentLoaded', loadInfo);

