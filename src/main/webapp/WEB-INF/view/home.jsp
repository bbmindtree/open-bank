<%@page import="com.openbank.util.CommonConstant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>
<style type="text/css">
html, body {
	background-color: #eee;
}

body {
	padding-top: 100px;
	adding-right: 300px;
}

/* The white background content wrapper */
.container>.content {
	background-color: #fff;
	padding: 20px;
}
</style>
<script>

function myFunction() {

    var val = document.getElementById("selected").value;
    if (val === "all") {
        CreateAllTableFromJSON();
    } else if (val === "sandbox") {
        CreateSandboxTableFromJSON()

    }else if (val === "total") {
        getTransactionsTotal()

    }

}


function CreateAllTableFromJSON() {

    var url = '<%= request.getContextPath()%><%=CommonConstant.ALL_TRANSACTIONS_MAPPING%>';
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, false);
    xhr.send();

    var data = JSON.parse(xhr.response);
    // EXTRACT VALUE FOR HTML HEADER. 

    var col = ['id', 'accountId', 'counterpartyAccount', 'counterpartyName', 'counterPartyLogoPath', 'instructedAmount', 'instructedCurrency', 'transactionAmount', 'transactionCurrency', 'transactionType', 'description'];

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1); // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th"); // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }
    console.log(data.transactions[0])
        // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < data.transactions.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            console.log(tabCell.innerHTML);

            if (col[j] === 'id') {
                tabCell.innerHTML = data.transactions[i].id;
            } else if (col[j] === 'accountId') {
                tabCell.innerHTML = data.transactions[i].this_account.id;
            } else if (col[j] === 'counterpartyAccount') {
                tabCell.innerHTML = data.transactions[i].other_account.number;
            } else if (col[j] === 'counterpartyName') {
                tabCell.innerHTML = data.transactions[i].other_account.holder.name;
            } else if (col[j] === 'counterPartyLogoPath') {
                tabCell.innerHTML = data.transactions[i].other_account.metadata.image_url;
            } else if (col[j] === 'instructedAmount') {
                tabCell.innerHTML = data.transactions[i].details.value.amount;
            } else if (col[j] === 'instructedCurrency') {
                tabCell.innerHTML = data.transactions[i].details.value.currency;
            } else if (col[j] === 'transactionAmount') {
                tabCell.innerHTML = data.transactions[i].details.value.amount;
            } else if (col[j] === 'transactionCurrency') {
                tabCell.innerHTML = data.transactions[i].details.value.currency;
            } else if (col[j] === 'transactionType') {
                tabCell.innerHTML = data.transactions[i].details.type;
            } else if (col[j] === 'description') {
                tabCell.innerHTML = data.transactions[i].details.description;
            }

        }
    }


    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function CreateSandboxTableFromJSON() {
    console.log("sandbox selected");


    var url = '<%= request.getContextPath()%><%=CommonConstant.FILTERED_TRANSACTIONS_MAPPING%>';

    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, false);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.setRequestHeader("transactiontype", "sandbox-payment");
    xhr.send();
    var data = JSON.parse(xhr.response);
   //Create Column
    var col = ['id', 'accountId', 'counterpartyAccount', 'counterpartyName', 'instructedAmount', 'instructedCurrency', 'transactionAmount', 'transactionCurrency', 'transactionType', 'description'];

    //create dymanic table
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1); // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th"); // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }
    console.log(data.transactions[0])
        // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < data.transactions.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            console.log(tabCell.innerHTML);

            if (col[j] === 'id') {
                tabCell.innerHTML = data.transactions[i].id;
            } else if (col[j] === 'accountId') {
                tabCell.innerHTML = data.transactions[i].this_account.id;
            } else if (col[j] === 'counterpartyAccount') {
                tabCell.innerHTML = data.transactions[i].other_account.number;
            } else if (col[j] === 'counterpartyName') {
                tabCell.innerHTML = data.transactions[i].other_account.holder.name;
            } else if (col[j] === 'instructedAmount') {
                tabCell.innerHTML = data.transactions[i].details.value.amount;
            } else if (col[j] === 'instructedCurrency') {
                tabCell.innerHTML = data.transactions[i].details.value.currency;
            } else if (col[j] === 'transactionAmount') {
                tabCell.innerHTML = data.transactions[i].details.value.amount;
            } else if (col[j] === 'transactionCurrency') {
                tabCell.innerHTML = data.transactions[i].details.value.currency;
            } else if (col[j] === 'transactionType') {
                tabCell.innerHTML = data.transactions[i].details.type;
            } else if (col[j] === 'description') {
                tabCell.innerHTML = data.transactions[i].details.description;
            }

        }
    }




    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}


function getTransactionsTotal() {
    console.log("sandbox selected");


    var url = '<%= request.getContextPath()%><%=CommonConstant.FILTERED_TRANSACTIONS_TOTAL_AMT_MAPPING%>';

    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, false);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.setRequestHeader("transactiontype", "sandbox-payment");
    xhr.send();
    var data = JSON.parse(xhr.response);
    // EXTRACT VALUE FOR HTML HEADER. 
    var totalAmount=data.totalamount;
    
    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "<h3>Total Amount</h3>"+ totalAmount;
    
}
</script>

</head>
<body>
	<div class="container">
		<div class="content">

			<span style="float: right"><a
				href="<c:url value="/j_spring_security_logout" />"> Logout</a></span>

			<div>
				<h2>Account Details :</h2>
				<select id="selected" onchange="myFunction()">
					<option value="select">Select</option>
					<option value="all">List all Transactions</option>
					<option value="sandbox">SandBox - Transaction Type</option>
					<option value="total">Fetch The Total Amount</option>
				</select>
				<div id="showData"></div>

			</div>


		</div>
	</div>
</body>
</html>
