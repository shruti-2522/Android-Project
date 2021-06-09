<?php $address = 'Big Bazar,College Road, Nashik' ; /* Insert address Here */

echo '<iframe width="100%" height="170" frameborder="0" src="https://maps.google.com/maps?f=q&source=s_q&hl=en&geocode=&q=' . str_replace(",", "", str_replace(" ", "+", $address)) . '&z=18&output=embed"></iframe>';
?>
     <iframe width="450" height="260" style="border: 1px solid #cccccc;" src="http://api.thingspeak.com/channels/31592/charts/1?width=450&height=260&results=60&dynamic=true" ></iframe>

<script>
 WebView webview;
    webview = (WebView) findViewById(R.id.webview);
    webview.loadData(html, "text/html", null);
    webview.getSettings().setJavaScriptEnabled(true);
    webview.loadData();
</script>