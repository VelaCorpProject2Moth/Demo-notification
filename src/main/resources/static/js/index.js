$(window).ready(function () {
  connect();
});

function connect() {
  //them sockJsProtocol de khong bi  exception sr356
  var sockJsProtocols = ["xhr-streaming", "xhr-polling"];
  var socket = new SockJS('/websocket',
      null, {transports: sockJsProtocols});
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/notifications', function (notification) {
      $('#textArea').val(notification);
    });
  });
}
