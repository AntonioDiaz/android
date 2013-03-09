package com.example.conectividad;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	private String mJsonStr;

	public JSONParser(String str) {
		super();
		if (str == null) {
			throw new NullPointerException();
		}
		mJsonStr = str;
	}

	public List<NodeImage> parser() {
		List<NodeImage> nodes = new ArrayList<NodeImage>();
		try {
			JSONObject root = new JSONObject(mJsonStr);
			if (root.has("results")) {
				JSONArray jsonArray = root.getJSONArray("results");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject nodo = jsonArray.getJSONObject(i);
					NodeImage parseNode = parseNode(nodo);
					if (parseNode != null) {
						nodes.add(parseNode);
					}
				}
			} else {
				return null;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nodes;
	}

	private NodeImage parseNode(JSONObject node) {
		NodeImage nodeImage = new NodeImage();
		try {
			if (node.has("name")) {
				nodeImage.setImageName(node.getString("name"));
			}
			if (node.has("since")) {
				nodeImage.setPhotoDate(node.getString("since"));
			}
			if (node.has("external_info")) {
				JSONObject jInfo = node.getJSONObject("external_info");
				if (jInfo.has("photo_thumb")) {
					nodeImage.setPhotoUrl(jInfo.getString("photo_thumb"));
				}
				if (jInfo.has("info_url")) {
					nodeImage.setInfoUrl(jInfo.getString("info_url"));
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nodeImage;
	}

}
