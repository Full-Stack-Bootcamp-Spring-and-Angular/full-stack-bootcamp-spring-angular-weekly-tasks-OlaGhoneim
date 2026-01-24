
<!DOCTYPE html>
<html>
<head>
    <title>Age Calculator</title>

    <!-- BOOTSTRAP -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow">
        <h3 class="text-center mb-4">Age Calculator</h3>

        <form action="/processForm">
            <div class="row">
                <div class="col">
                    <input type="number" name="year" class="form-control" placeholder="Year" required>
                </div>
                <div class="col">
                    <input type="number" name="month" class="form-control" placeholder="Month" required>
                </div>
                <div class="col">
                    <input type="number" name="day" class="form-control" placeholder="Day" required>
                </div>
            </div>

            <button class="btn btn-primary mt-3 w-100">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
