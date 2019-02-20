#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#define On '0'


ESP8266WebServer server(80);   
//接入的路由器参数
const char* ssid = "test001";
const char* password = "maxiuying00";

//web页面
String form ="刷新";

void setup() {
  Serial.begin(115200);
  Serial.print("start");
  Serial.println(' ');
  pinMode(0, OUTPUT); 
  pinMode(2, OUTPUT); 
  pinMode(12, OUTPUT); 
  pinMode(13, OUTPUT); 
  pinMode(14, OUTPUT); 
  pinMode(15, OUTPUT); 
  pinMode(16, OUTPUT); 
  pinMode(3, OUTPUT); 
  delay(3*1000);
  Serial.print("Start WiFi...");
  Serial.println(' ');
  //初始化wifi
//  WiFi.disconnect();
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid,password);
  //显示连接的热点
  Serial.print("Connecting to "); 
  char *buf = new char[strlen(ssid)+1];
  strcpy(buf, ssid);
  Serial.print(buf);
  Serial.println(' ');
  int c=1;
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    if(c>15)
      c=1;
    Serial.println(c++);
  }
  //清除内容
  //整理转化wifi信息
  char sip[16];
  char smac[16];
  uint8_t mac[6];
  WiFi.macAddress(mac);
  IPAddress ip = WiFi.localIP();
  sprintf(sip, "%i.%i.%i.%i",ip[0],ip[1],ip[2],ip[3]);
  sprintf(smac, "%02X%02X%02X%02X%02X%02X",mac[0], mac[1], mac[2], mac[3], mac[4], mac[5]);
  //显示wifi信息
  Serial.print("WIFI Message:");
  Serial.print("IP:");
  Serial.print(sip);
  Serial.println(' ');
  Serial.print("MAC:");
  Serial.print(smac);
  Serial.println(' ');
  //响应浏览器访问
  server.on("/",[]() {server.send(200, "text/html", form);});
  server.on("/msg", handle_msg);
  server.begin();   
}

void loop() {
  //监听客户端请求
  server.handleClient();
}
//发送web页面，显示收到的数据
void handle_msg() {
  char msg[50];
  strcpy(msg,server.arg("msg").c_str());
  Serial.print("Receive:");
  Serial.print(msg);
  Serial.println(' ');
  Serial.print(form);
  Serial.println(' ');
  switch(msg[0]){
    case '0':
      if(msg[1]==On){
        digitalWrite(0, LOW); 
      }
      else{
        digitalWrite(0, HIGH);  
      }
      break;
    case '1':
      if(msg[1]==On){
        digitalWrite(2, LOW); 
      }
      else{
        digitalWrite(2, HIGH);  
      }
      break;
    case '2':
      if(msg[1]==On){
        digitalWrite(12, LOW); 
      }
      else{
        digitalWrite(12, HIGH);  
      }
      break;
    case '3':
      if(msg[1]==On){
        digitalWrite(13, LOW); 
      }
      else{
        digitalWrite(13, HIGH);  
      }
      break;
    case '4':
      if(msg[1]==On){
        digitalWrite(14, LOW); 
      }
      else{
        digitalWrite(14, HIGH);  
      }
      break;
    case '5':
      if(msg[1]==On){
        digitalWrite(15, LOW); 
      }
      else{
        digitalWrite(15, HIGH);  
      }
      break;
    case '6':
      if(msg[1]==On){
        digitalWrite(16, LOW); 
      }
      else{
        digitalWrite(16, HIGH);  
      }
      break;
    case '7':
      if(msg[1]==On){
        digitalWrite(3, LOW); 
      }
      else{
        digitalWrite(3, HIGH);  
      }
      break;   
  }
    form = "";
  if(digitalRead(0))
    form+='1';
  else
    form+='0';
  if(digitalRead(2))
    form+='1';
  else
    form+='0';
  if(digitalRead(12))
    form+='1';
  else
    form+='0';
  if(digitalRead(13))
    form+='1';
  else
    form+='0';
  if(digitalRead(14))
    form+='1';
  else
    form+='0';
  if(digitalRead(15))
    form+='1';
  else
    form+='0';
  if(digitalRead(16))
    form+='1';
  else
    form+='0';
  if(digitalRead(3))
    form+='1';
  else
    form+='0';  
  server.send(200, "text/html", form);
}
