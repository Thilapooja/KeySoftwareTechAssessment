const backendUrl = "http://localhost:8080/api"; 
// Utility to add item to list
function addToList(ulId, text) {
    const ul = document.getElementById(ulId);
    const li = document.createElement("li");
    li.textContent = text;
    ul.appendChild(li);
}

// ===== CATEGORY =====
function createCategory() {
    const name = document.getElementById("categoryName").value;
    fetch(`${backendUrl}/categories`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name })
    })
    .then(res => res.json())
    .then(data => {
        addToList("categoryList", `${data.categoryId} - ${data.name}`);
        document.getElementById("categoryName").value = "";
        loadCategories(); // update dropdowns
    });
}

function loadCategories() {
    fetch(`${backendUrl}/categories`)
        .then(res => res.json())
        .then(categories => {
            const attrCat = document.getElementById("attributeCategory");
            const prodCat = document.getElementById("productCategory");
            attrCat.innerHTML = "";
            prodCat.innerHTML = "";
            categories.forEach(c => {
                const option = document.createElement("option");
                option.value = c.categoryId;
                option.text = c.name;
                attrCat.add(option.cloneNode(true));
                prodCat.add(option.cloneNode(true));
            });
        });
}

// ===== ATTRIBUTE =====
function createAttribute() {
    const name = document.getElementById("attributeName").value;
    const dataType = document.getElementById("attributeType").value;
    const categoryId = document.getElementById("attributeCategory").value;

    fetch(`${backendUrl}/attributes`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, dataType, categoryId })
    })
    .then(res => res.json())
    .then(data => {
        addToList("attributeList", `${data.attributeId} - ${data.name} (${data.dataType})`);
        document.getElementById("attributeName").value = "";
        loadAttributes(categoryId);
    });
}

function loadAttributes(categoryId) {
    fetch(`${backendUrl}/attributes/category/${categoryId}`)
        .then(res => res.json())
        .then(attributes => {
            const attrSelect = document.getElementById("attributeSelect");
            attrSelect.innerHTML = "";
            attributes.forEach(a => {
                const option = document.createElement("option");
                option.value = a.attributeId;
                option.text = a.name;
                attrSelect.add(option);
            });
        });
}

// ===== PRODUCT =====
function createProduct() {
    const name = document.getElementById("productName").value;
    const categoryId = document.getElementById("productCategory").value;

    fetch(`${backendUrl}/products`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, categoryId })
    })
    .then(res => res.json())
    .then(data => {
        addToList("productList", `${data.productId} - ${data.name}`);
        document.getElementById("productName").value = "";
        loadProducts(categoryId);
    });
}

function loadProducts(categoryId) {
    fetch(`${backendUrl}/products`)
        .then(res => res.json())
        .then(products => {
            const prodSelect = document.getElementById("productSelect");
            prodSelect.innerHTML = "";
            products.forEach(p => {
                const option = document.createElement("option");
                option.value = p.productId;
                option.text = p.name;
                prodSelect.add(option);
            });
        });
}

// ===== PRODUCT ATTRIBUTE VALUE =====
function addProductAttributeValue() {
    const productId = document.getElementById("productSelect").value;
    const attributeId = document.getElementById("attributeSelect").value;
    const value = document.getElementById("attributeValue").value;

    fetch(`${backendUrl}/product-attributes`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ productId, attributeId, value })
    })
    .then(res => res.json())
    .then(data => {
        addToList("productAttributeList", `Product ${data.productId}, Attribute ${data.attributeId}: ${data.value}`);
        document.getElementById("attributeValue").value = "";
    });
}

// ===== Initialize on Load =====
window.onload = function() {
    loadCategories();
    loadProducts();
};

