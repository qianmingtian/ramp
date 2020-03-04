# Real Ad-hoc Multi-hop Peer-to-peer (RAMP) Getting Started

## Run instructions

* Download the latest RampStandAloneClient_YYYY-MM-DD.zip contained in `ramp/deployment` folder.
* Extract the zip file in your desired location
* Open a terminal in the extracted folder RampStandAloneClient_YYYY-MM-DD

On Linux
* Run RAMP - using `./ramp.sh`

On Windows
* Run RAMP - using `ramp.bat`

The RAMP main window will appear meaning that the middleware is up and running.

RAMP 主窗口出现意味着中间件启动并在运行。

<p align="center">
  <img src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_GUI.jpg?raw=true" alt="RAMP Main Window"/>
</p>

## RAMP Multi-LANE Setup Guide
## 指南

<p align="left">
  <img width="100" src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_Multi-LANE.png?raw=true" alt="RAMP Multi-LANE Logo"/>
</p>

Multi-Layer Advanced Networking Environment (Multi-LANE) middleware, originally adopts a Multi Layer Routing (MLR) approach in conjunction with SDN to fully enhance the capabilities of heterogeneous Fog environments.

In this quick tutorial is shown how to use RAMP Multi-LANE in a topology of three nodes.

多层高级网络环境（Multi-Layer Advanced Networking Environment，Multi-LANE）中间件，最初采用多层路由（Multi-Layer Routing，MLR）的方法，结合SDN，充分增强了异构 Fog 环境的性能。              

在本快速教程中，将演示如何在三个节点的拓扑中使用RAMP。

<p align="center">
  <img src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_TopologyExample.jpg?raw=true" alt="RAMP Topology Example"/>
</p>

Let's assume that you have a topology like the one showed in the above picture. What we are going to do is to configure RAMP Multi-LANE so that:
* The node 1 will act both as SDN Controller and SDN Client
* The node 2 will act as SDN Client
* The node 3 will act as SDN Client

假设您有一个如上图所示的拓扑结构。我们要做的是配置 RAMP ，以便：              
* 节点1将同时充当SDN控制器和SDN客户端              
* 节点2将充当SDN客户端              
* 节点3将充当SDN客户端
### Configure the RAMP ID on each node

Once downloaded the the latest RampStandAloneClient_YYYY-MM-DD.zip contained in `ramp/deployment` folder on each node, before running the RAMP Middleware is important to set the right RAMP ID. To do so:
* Extract the zip file in your desired location
* Open the extracted folder and open with a text editor the file `resource/ramp.props` and set the right ID in the `nodeID` field

The above steps must be done for each node so for node 1 the `nodeID` value should be set to 1, for node 2 the value should be 2 and so on.

### 在每个节点上配置RAMP ID
下载每个节点上“ramp/deployment”文件夹中包含的最新RampStandAloneClient_yyy-MM-DD.zip后，在运行ramp中间件之前，设置正确的ramp ID非常重要。为此：
* 在所需位置提取zip文件              
* 打开提取的文件夹，用文本编辑器打开文件“resource/ramp.props”，并在“nodeID”字段中设置正确的ID              

必须对每个节点执行上述步骤，因此对于节点1，“nodeID”值应设置为1，对于节点2，该值应设置为2，依此类推。

### Run the SDN Controller

Launch RAMP on node 1

### 运行 SDN 控制器

启动节点1上的 RAMP
<p align="center">
  <img src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_GUI.jpg?raw=true" alt="RAMP Main Window"/>
</p>

In order to launch the SDN Controller, in the Application section of the RAMP main window (top-left) select in the drop-down list the service called `SDNControllerService` and press the button `start selected service`. 

It's important to note that at the moment only one SDN Controller service is supported in a topology. This means that only one node can act as a SDN Controller.

为了启动SDN控制器，在RAMP主窗口的Application部分（左上角）从下拉列表中选择名为“SDN Controller service”的服务，然后按“start selected service”按钮。
需要注意的是，目前拓扑中只支持一个SDN控制器服务。这意味着只有一个节点可以充当SDN控制器。

<p align="center">
  <img src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_SDNControllerService.jpg?raw=true" alt="RAMP SDN Controller"/>
</p>

The picture above shows the SDNControllerService GUI, through it you can control the behaviour of the topology. In particular:
* In the `Traffic Engineering Policy` section you can set policy in case of messages having different priorities. If you don't want to use this feature select the value NO_FLOW_POLICY and click on the button Update Traffic Policy.
* In the `Routing Policy` section you can set the routing policy that all SDN Client must follow in order to perform the application-level routing. By setting NO_ROUTING_POLICY the routing inside the SDN will follow a Dynamic Source Routing strategy.
* In the `Active Clients` section you can get a list of all SDN Clients managed by this Controller.
* In the `Topology Graph` section you can get a visual representation of the topology.
* The other sections are related to highest level routing features that RAMP Multi-LANE offers.

上图显示了 SDNControllerService GUI ，通过它您可以控制拓扑的行为。特别地：
*在 `Traffic Engineering Policy` 部分，您可以设置策略，以防邮件具有不同的优先级。如果不想使用此功能，请选择“无流量”策略值，然后单击“更新流量策略”按钮。
*在 `Routing Policy` 部分中，可以设置所有SDN客户端必须遵循的路由策略，以便执行应用程序级路由。通过设置无路由策略， SDN 内的路由将遵循动态源路由策略。
*在 `Active Clients` 部分，您可以获取由该控制器管理的所有SDN客户端的列表。
*在 `Topology Graph` 部分，您可以获得拓扑的可视化表示。
*其他部分与匝道多车道提供的最高级别路由功能相关。

### Run the SDN Client

For node 1 since RAMP is already running from the RAMP main window you only need to launch the SDN Client by selecting `SDNControllerClient` and press the button `start selected client` in the Applications section. 

It will ask you the root password used to make the OS Routing Mode working, such feature will create and manage several local ip tables. The source code of this feature is contained in the OSRoutingManager.java.

For node 2 and node 3 you need first run RAMP on each node and after that launch only the SDNControllerClient application.

### 运行SDN客户端
对于节点1，因为 RAMP 已经从 RAMP 主窗口运行，所以只需要选择 `SDNControllerClient` 并按“应用程序”部分中的 `start selected client` 按钮，即可启动SDN客户端。
它将询问您用于使操作系统路由模式工作的根密码，这样的功能将创建和管理多个本地ip表。此功能的源代码包含在OSRoutingManager.java中。
对于节点2和节点3，首先需要在每个节点上运行 RAMP ，然后只启动  SDNControllerClient 应用程序。
<p align="center">
  <img src="https://github.com/DSG-UniFE/ramp/blob/master/deployment/images/RAMP_SDNControllerClient.jpg?raw=true" alt="RAMP SDN Client"/>
</p>

Now that all three nodes are running the SDN RAMP applications, in order to verify that the SDN Controller service is managing the three SDN Clients click on the `Get Active Clients` button in the SDNControllerService GUI on node 1. Also by clicking the `Get Topology Graph` button you can monitor the real-time visual representation of the topology.

The picture above shows the SDNControllerClient GUI, through it you can monitor the policies currently active in the topology and communicate with the other SDN Clients. In particular:
* In the `Traffic Engineering Policy` section you can see the active policy in case of messages having different priorities.
* In the `Routing Policy` section you can see the active routing policy set by the SDN Controller.
  
现在，所有三个节点都在运行SDN RAMP应用程序，为了验证SDN控制器服务是否正在管理三个SDN客户端，请单击节点1上SDN Controller service GUI中的 `Get Active Clients` 按钮。也可以通过单击 `Get Topology Graph` 按钮来监视拓扑的实时可视化表示。
上图显示了SDNControllerClient GUI，通过它，您可以监视拓扑中当前活动的策略，并与其他SDN客户机通信。特别地：
* 在 `Traffic Engineering Policy` 部分，您可以看到当消息具有不同优先级时的活动策略。
* 在 `Routing Policy` 部分，您可以看到SDN控制器设置的活动路由策略。

### Example of communication based on Flow
Assume that we want to send a message from node 1 to node 3 based on flow.

In the SDNControllerClient GUI on node 1:
* Select the protocol you want to use (TCP or UDP) and press the `Find Nodes` button in the Available SDN Controller Client Receivers section. You will see all the available clients.
* The `Destination Node ID` drop-down list will be automatically filled in the Flow ID section, select 3 and press the button `Get Flow ID`.
* In the Send Packet section in the right-side select 3 as `Destination ID`, select the flowID available in the `FlowID` drop-down list.
* Press the `Send Packet` button to send the packet.

In the SDNControllerClient GUI on node 3:
* To view the received message click on the `Update Log` button in the right-bottom.

### 基于流的通信示例
假设我们要基于流从节点1发送消息到节点3。

在节点1上的 SDNControllerClient GUI 中：
* 选择要使用的协议（TCP或UDP），然后按“可用SDN控制器客户端接收器”部分中的 `Find Nodes` 按钮。您将看到所有可用的客户端。
*  `Destination Node ID` 下拉列表将自动填入Flow ID部分，选择3并按 `Get Flow ID` 按钮。
* 在右侧的Send Packet部分，选择3作为 `Destination ID` ，在 `FlowID` 下拉列表中选择可用的flowID。
* 按 `Send Packet` 按钮发送数据包。
  
在节点3上的 SDNControllerClient GUI 中：
* 要查看收到的邮件，请单击右下角的 `Update Log` 按钮。

### Example of communication based on OS Level Routing
Assume that we want to send a message from node 1 to node 3 based on OS Level Routing.

In the SDNControllerClient GUI on node 1:
* Switch the view by selecting the `OsRouting Mode` checkbox in the top-left.
* Select the protocol you want to use (TCP or UDP) and press the `Find Nodes` button in the Available SDN Controller Client Receivers section. You will see all the available clients.
* The `Destination Node ID` drop-down list will be automatically filled in the Route ID section, select 3 and press the button `Get Route ID`.
* In the Send Packet section in the right-side select 3 as `Destination ID`, select the RouteID available in the `RouteID` drop-down list.
* Press the `Send Packet` button to send the packet.

In the SDNControllerClient GUI on node 3:

* To view the received message click on the `Update Log` button in the right-bottom.

### 基于操作系统级路由的通信实例
假设我们要基于操作系统级路由将消息从节点1发送到节点3。
在节点1上的SDNControllerClient GUI中：
* 通过选中左上角的 `OsRouting Mode` 复选框切换视图。
* 选择要使用的协议（TCP或UDP），然后按可用SDN控制器客户端接收器部分中的 `Find Nodes` 按钮。您将看到所有可用的客户端。
*  `Destination Node ID` 下拉列表将自动填入Route ID部分，选择3并按 `Get Route ID` 按钮。
* 在右侧的Send Packet部分，选择3作为 `Destination ID` ，在 `RouteID` 下拉列表中选择可用的RouteID。
* 按 `Send Packet` 按钮发送数据包。
在节点3上的SDNControllerClient GUI中：
* 要查看收到的邮件，请单击右下角的 `Update Log` 按钮。

### Graceful RAMP shut-down
In order to avoid any kind of inconsistencies, it is recommended to follow these steps to shutdown RAMP.
* Close the SDNControllerClient and close the RAMP main window on node 3.
* Close the SDNControllerClient and close the RAMP main window on node 2.
* Close the SDNControllerClient, close the SDNControllerService and close the RAMP main window on node 1. 

In case of usage of OS Routing Level features if you don't follow the above steps you may have some left local routing table in your machine. Since they are ephemeral you just need to reboot the machine to get rid of them.













