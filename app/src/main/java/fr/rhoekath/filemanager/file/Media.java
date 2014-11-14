package fr.rhoekath.filemanager.file;

import fr.rhoekath.filemanager.utils.Tools;

import static fr.rhoekath.filemanager.utils.Tools.Type;

/**
 * Created by Mickael on 14/11/2014.
 */
public class Media {
    private final String name, path;
    private final int versionCode;
    private final Type mediaType;

    public Media(String name, String path, int versionCode, Type mediaType) {
        this.name = name;
        this.path = path;
        this.versionCode = versionCode;
        this.mediaType = mediaType;
    }

    public Type getMediaType() {
        return mediaType;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getVersionCode() {
        return versionCode;
    }


}


