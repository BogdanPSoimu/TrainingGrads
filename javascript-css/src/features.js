/**
 * Created by bsoimu on 8/2/2016.
 */
function validateForm() {
    var x = document.getElementById("nume").value;
    var y = document.getElementById("prenume").value;
    var z = document.getElementById("mail").value;
    
    if ((x == null || x == "") && (y == null || y == "") && (z == null || z == "")) {
        document.getElementById("numeAlert").innerHTML = "Completati numele.";
        document.getElementById("prenumeAlert").innerHTML = "Completati prenumele.";
        document.getElementById("mailAlert").innerHTML = "Completati mail-ul.";
        return false;
    }

    if ((x == null || x == "") && (y == null || y == "")) {
        document.getElementById("numeAlert").innerHTML = "Completati numele.";
        document.getElementById("prenumeAlert").innerHTML = "Completati prenumele.";
        return false;
    }

    if ((x == null || x == "") && (z == null || z == "")) {
        document.getElementById("numeAlert").innerHTML = "Completati numele.";
        document.getElementById("mailAlert").innerHTML = "Completati mail-ul.";
        return false;
    }

    if (x == null || x == "") {
        document.getElementById("numeAlert").innerHTML = "Completati numele.";
        return false;
    }

    if ((y == null || y == "") && (z == null || z == "")) {
        document.getElementById("prenumeAlert").innerHTML = "Completati prenumele.";
        document.getElementById("mailAlert").innerHTML = "Completati mail-ul.";
        return false;
    }
    
    if (y == null || y == "") {
        document.getElementById("prenumeAlert").innerHTML = "Completati prenumele.";
        return false;
    }
    
    if (z == null || z == "") {
        document.getElementById("mailAlert").innerHTML = "Completati mail-ul.";
        return false;
    }
}