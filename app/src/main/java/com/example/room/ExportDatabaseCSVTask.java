//call this task
/*ExportDatabaseCSVTask task=new ExportDatabaseCSVTask();
task.execute();*/

private class ExportDatabaseCSVTask extends AsyncTask<String ,String, String>{
    private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
    @Override
    protected void onPreExecute() {
        this.dialog.setMessage("Exporting database...");
        this.dialog.show();
    }

    protected String doInBackground(final String... args){
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "ExcelFile.csv");
        try {

            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));

            //data
            ArrayList<String> listdata= new ArrayList<String>();
            listdata.add("Aniket");
            listdata.add("Shinde");
            listdata.add("pune");
            listdata.add("anything@anything");
            //Headers
            String arrStr1[] ={"First Name", "Last Name", "Address", "Email"};
            csvWrite.writeNext(arrStr1);

            String arrStr[] ={listdata.get(0), listdata.get(1), listdata.get(2), listdata.get(3)};
            csvWrite.writeNext(arrStr);

            csvWrite.close();
            return "";
        }
        catch (IOException e){
            Log.e("MainActivity", e.getMessage(), e);
            return "";
        }
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPostExecute(final String success) {

        if (this.dialog.isShowing()){
            this.dialog.dismiss();
        }
        if (success.isEmpty()){
            Toast.makeText(MainActivity.this, "Export successful!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Export failed!", Toast.LENGTH_SHORT).show();
        }
    }
}
