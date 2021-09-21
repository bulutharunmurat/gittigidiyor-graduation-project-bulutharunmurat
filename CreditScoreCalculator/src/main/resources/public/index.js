const table = document.getElementById("userTable");

function getCustomerList() {
  fetch("http://localhost:8080/api/customers")
    .then((response) => response.json())
    .then((data) => {
      for (customer of data) {
        console.log(customer);
        table.innerHTML += `
          <tr>
          <td><input type="text" class="form-control" id="customer_ssid_${customer.ssid}" value="${customer.ssid}" readonly></td>
          <td><input type="text" class="form-control" id="customer_name_${customer.ssid}" value="${customer.customerName}"></td>
          <td><input type="text" class="form-control" id="customer_salary_${customer.ssid}" value="${customer.customerSalary}"></td>
          <td><input type="text" class="form-control" id="customer_phonenumber_${customer.ssid}" value="${customer.customerPhoneNumber}"></td>
          <td><button type="button" class="btn btn-primary" onclick='updateCustomer(${customer.ssid})'>Update Customer </td>
          <td><button type="button" class="btn btn-primary" onclick='deleteCustomer(${customer.ssid})'>Delete Customer</td>
      </tr>`;
      }
    });
}

function refreshData() {
  getCustomerList();
}

function createCustomer() {
  let customer = {
    ssid: document.getElementById("customer_ssid").value || "EMPTY VALUE!!!",
    customerName:
      document.getElementById("customer_name").value || "EMPTY VALUE!!!",
    customerSalary:
      document.getElementById("customer_salary").value || "EMPTY VALUE!!!",
    customerPhoneNumber:
      document.getElementById("customer_phonenumber").value || "EMPTY VALUE!!!"
  };

  fetch("http://localhost:8080/api/customers", {
    method: "post",
    body: JSON.stringify(customer),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      table.innerHTML += `<tr>
      <td><input type="text" class="form-control" id="customer_ssid_${data.ssid}" value="${data.ssid}" readonly></td>
      <td><input type="text" class="form-control" id="customer_name_${data.ssid}" value="${data.customerName}"></td>
      <td><input type="text" class="form-control" id="customer_salary_${data.ssid}" value="${data.customerSalary}"></td>
      <td><input type="text" class="form-control" id="customer_phonenumber_${data.ssid}" value="${data.customerPhoneNumber}"></td>
      <td><button type="button" class="btn btn-primary" onclick='updateCustomer(${data.ssid})'>Update Customer </td>
      <td><button type="button" class="btn btn-primary" onclick='deleteCustomer(${data.ssid})'>Delete Customer</td>
  </tr>`;
    })
    .catch((error) => {
      console.log("error", error);
    });
}

function updateCustomer(customerssid) {
  console.log("deneme");
  console.log(customerssid);

  let customer = {
    ssid:
      document.getElementById("customer_ssid_" + customerssid).value ||
      "EMPTY VALUE!!!",
    customerName:
      document.getElementById("customer_name_" + customerssid).value ||
      "EMPTY VALUE!!!",
    customerSalary:
      document.getElementById("customer_salary_" + customerssid).value ||
      "EMPTY VALUE!!!",
    customerPhoneNumber:
      document.getElementById("customer_phonenumber_" + customerssid).value ||
      "EMPTY VALUE!!!"
  };

  fetch("http://localhost:8080/api/customers", {
    method: "PUT",
    body: JSON.stringify(customer),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("customer Updated", data);
    })
    .catch((error) => {
      console.log("error", error);
    });
}


function deleteCustomer(ssid) {
    fetch("http://localhost:8080/api/customers/" + ssid, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
    }
  })
  .then(response => console.log(response))
  .then(data => {
    console.log("customer Deleted", data);
  })
  .catch((error) => {
    console.log("error", error);
  });
  }
  
getCustomerList();