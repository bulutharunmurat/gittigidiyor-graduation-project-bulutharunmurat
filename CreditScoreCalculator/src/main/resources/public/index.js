const table = document.getElementById("customerTable");

function getCustomerList() {
  fetch("http://localhost:8080/api/customers")
      .then((response) => response.json())
      .then((data) => {
        for (customer of data) {
          table.innerHTML += `
          <tr>
          <td><input type="text" class="form-control" id="customer_ssid_${customer.ssid}" value="${customer.ssid}" readonly></td>
          <td><input type="text" class="form-control" id="customer_name_${customer.ssid}" value="${customer.customerName}"></td>
          <td><input type="text" class="form-control" id="customer_salary_${customer.ssid}" value="${customer.customerSalary}"></td>
          <td><input type="text" class="form-control" id="customer_phonenumber_${customer.ssid}" value="${customer.customerPhoneNumber}"></td>
          <td><button type="button" class="btn btn-info" onclick='updateCustomer(${customer.ssid})'>Update Customer </td>
          <td><button type="button" class="btn btn-info" onclick='deleteCustomer(${customer.ssid})'>Delete Customer</td>
          <td><button type="button" class="btn btn-success" onclick='creditRequest(${customer.ssid})'>Make Credit Request</td>
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
        document.getElementById("customer_phonenumber").value || "EMPTY VALUE!!!",
  };

  fetch("http://localhost:8080/api/customers", {
    method: "post",
    body: JSON.stringify(customer),
    headers: {
      "Content-Type": "application/json",
    },
  })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        table.innerHTML += `<tr>
      <td><input type="text" class="form-control" id="customer_ssid_${data.ssid}" value="${data.ssid}" readonly></td>
      <td><input type="text" class="form-control" id="customer_name_${data.ssid}" value="${data.customerName}"></td>
      <td><input type="text" class="form-control" id="customer_salary_${data.ssid}" value="${data.customerSalary}"></td>
      <td><input type="text" class="form-control" id="customer_phonenumber_${data.ssid}" value="${data.customerPhoneNumber}"></td>
      <td><button type="button" class="btn btn-info" onclick='updateCustomer(${data.ssid})'>Update Customer </td>
      <td><button type="button" class="btn btn-info" onclick='deleteCustomer(${data.ssid})'>Delete Customer</td>
      <td><button type="button" class="btn btn-success" onclick='creditRequest(${data.ssid})'>Make Credit Request</td>

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
        "EMPTY VALUE!!!",
  };

  fetch("http://localhost:8080/api/customers", {
    method: "PUT",
    body: JSON.stringify(customer),
    headers: {
      "Content-Type": "application/json",
    },
  })
      .then((response) => response.json())
      .then((data) => {
        console.log("customer Updated", data);
      })
      .catch((error) => {
        console.log("error", error);
      });
    window.location.reload()
}

function deleteCustomer(ssid) {
  fetch("http://localhost:8080/api/customers/" + ssid, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  })
      .then((response) => console.log(response))
      .then((data) => {
        console.log("customer Deleted", data);
      })
      .catch((error) => {
        console.log("error", error);
      });
    window.location.reload()
}

getCustomerList();

const creditRequestTable = document.getElementById("creditResponseTable");

function creditRequest(ssid){

  let today = new Date();

  let date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate()+ " " + today.getHours() + ":" + today.getMinutes();


  fetch("http://localhost:8080/api/credit-request/" + ssid, {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
  })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        creditRequestTable.innerHTML = `<tr>
      <td><input type="text" class="form-control" id="customer_ssid_${data.id}" value="${data.id}" readonly></td>
      <td><input type="text" class="form-control" id="customer_ssid_${ssid}" value="${ssid}" readonly></td>
      <td><input type="text" class="form-control" id="customer_ssid_${date}" value="${date}" readonly></td>
      <td><input type="text" class="form-control" id="customer_name_${data.creditResponseType}" value="${data.creditResponseType}"></td>
      <td><input type="text" class="form-control" id="customer_salary_${data.creditLimit}" value="${data.creditLimit}"></td>
  </tr>`;
      })
      .catch((error) => {
        console.log("error", error);
      });

}
const creditRequestsOfCustomerTable = document.getElementById("creditResponseOfCustomerTable");

function getCreditRequestWithCustomerSSID() {

    let ssid = document.getElementById('ssid').value;

    fetch("http://localhost:8080/api/credit-request/" + ssid)
        .then((response) => response.json())
        .then((data) => {

            for (creditRequest of data) {

                creditRequestsOfCustomerTable.innerHTML += `
          <tr>
          <td><input type="text" class="form-control" id="customer_ssid_${creditRequest.id}" value="${creditRequest.id}"></td>
          <td><input type="text" class="form-control" id="customer_ssid_${creditRequest}" value="${ssid}"></td>
          <td><input type="text" class="form-control" id="customer_name_${creditRequest.creditResponseType}" value="${creditRequest.creditResponseType}"></td>
          <td><input type="text" class="form-control" id="customer_phonenumber_${creditRequest.creditLimit}" value="${creditRequest.creditLimit}"></td>
      </tr>`;
            }
        });
}
