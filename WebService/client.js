fetch("http://127.0.0.1:5000/employees")
    .then(res => {
        return res.json()
    })
    .then(data => {
        console.log(data)
        var row = document.querySelector("#list")
        var text = ""
        data.forEach(emp => {
            text += `
                        <div class="col-md-4">
                            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                                <div class="col p-4 d-flex flex-column position-static">
                                    <strong class="d-inline-block mb-2 text-primary">${emp.name}</strong>
                                    <h3 class="mb-0">${emp.title}</h3>
                                </div>
                            </div>
                        </div>
                    `
        })
        row.innerHTML = text
    })
    .catch(error => console.log(error))